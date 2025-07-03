package br.shiton.short_link.infrastructure.api.controller;

import br.shiton.short_link.usecase.link.create.CreateLinkUseCase;
import br.shiton.short_link.usecase.link.create.InputCreateLinkDTO;
import br.shiton.short_link.usecase.link.create.OutputCreateLinkDTO;
import br.shiton.short_link.usecase.link.exception.NotFoundException;
import br.shiton.short_link.usecase.link.get.GetLinkUseCase;
import br.shiton.short_link.usecase.link.get.InputGetLinkDTO;
import br.shiton.short_link.usecase.link.get.OutputGetLinkDTO;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/links")
public class LinkController {

    @Autowired
    private CreateLinkUseCase createLinkUseCase;
    @Autowired
    private GetLinkUseCase getLinkUseCase;

    @PostMapping
    public OutputCreateLinkDTO create(@RequestBody InputCreateLinkDTO requestBody) throws NoSuchAlgorithmException {
        try{
            return createLinkUseCase.execute(requestBody);
        } catch (Exception e){
            System.out.println("Log de erro aqui");
            throw e;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLink(@PathVariable("id") UUID id) {
        try {
            return ResponseEntity.ok(getLinkUseCase.execute(new InputGetLinkDTO(id)));
        }catch (NotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ResponseError(e.getMessage()));
        } catch (Exception e) {
            System.out.println("Log de erro aqui");
            throw e; // rethrow or handle the exception as needed
        }
    }
}
