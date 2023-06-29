package com.llacerximo.spring.datajpa.controller;

import com.llacerximo.spring.datajpa.exception.ClientNotFoundException;
import com.llacerximo.spring.datajpa.models.entity.Client;
import com.llacerximo.spring.datajpa.models.service.ClientService;
import com.llacerximo.spring.datajpa.models.service.UploadFileService;
import com.llacerximo.spring.datajpa.util.paginator.PageRender;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

@Controller
@SessionAttributes("client")
public class ClientController {

    @Autowired
    @Qualifier("clientServiceJPA")
    private ClientService clientService;

    @Autowired
    private UploadFileService uploadFileService;

    @GetMapping("/clients")
    public String getAll(@RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 4);
        Page<Client> clients = clientService.getAll(pageRequest);
        PageRender<Client> pageRender = new PageRender<>("/clients", clients);
        model.addAttribute("title", "Client List");
        model.addAttribute("clients", clients);
        model.addAttribute("page", pageRender);
        return "clients";
    }

    @GetMapping("/clients/{id}")
    public String getById(@PathVariable Long id, Model model) throws ClientNotFoundException {
        Client client = clientService.getById(id);
        if (client == null) {
            throw new ClientNotFoundException("Client not found in the Database");
        }
        model.addAttribute("client", client);
        model.addAttribute("title", "Details for: " + client.getName());
        return "client";
    }

    @GetMapping("/form")
    public String form(Map<String, Object> model) {
        Client client = new Client();
        model.put("client", client);
        model.put("title", "Client Form");
        return "form";
    }

    @PostMapping("/form")
    public String insert(@Valid Client client, BindingResult result, @RequestParam("file") MultipartFile img,
                         SessionStatus status) {
        if (result.hasErrors()) {
            return "form";
        }
        if (!img.isEmpty()) {

            if (client.getId() != null && client.getImg() != null && client.getImg().length() > 0) {
                uploadFileService.delete(client.getImg());
            }
            try {
                client.setImg(uploadFileService.copy(img));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        clientService.insert(client);
        status.setComplete();
        return "redirect:/clients";
    }

    @GetMapping("/uploads/{filename:.+}")
    public ResponseEntity<Resource> viewImg (@PathVariable String filename) {
        Resource resource = null;
        try {
            resource = uploadFileService.load(filename);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping("/form/{id}")
    public String getById(@PathVariable Long id, Map<String, Object> model) {
        Client client = null;
        if (id > 0) {
            client = clientService.getById(id);
        } else {
            return "redirect:/clients";
        }
        model.put("client", client);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        if (id > 0) {
            Client client = clientService.getById(id);
            clientService.delete(id);
            uploadFileService.delete(client.getImg());
        }
        return "redirect:/clients";
    }
}
