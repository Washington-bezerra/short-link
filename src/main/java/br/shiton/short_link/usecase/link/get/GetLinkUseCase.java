package br.shiton.short_link.usecase.link.get;

import br.shiton.short_link.infrastructure.link.repository.mongoDB.LinkRepository;
import br.shiton.short_link.usecase.link.exception.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class GetLinkUseCase {

    private final LinkRepository repository;

    public GetLinkUseCase(LinkRepository repository) {
        this.repository = repository;
    }

    public OutputGetLinkDTO execute(InputGetLinkDTO input) {
        return repository.findById(input.id())
                .map(link -> new OutputGetLinkDTO(
                        link.getId(),
                        link.getUrl(),
                        link.getShortUrl(),
                        link.getCreatedAt()
                ))
                .orElseThrow(() -> new NotFoundException("Link with id " + input.id() + " not found"));
    }

}
