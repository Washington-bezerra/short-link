package br.shiton.short_link.usecase.link.create;

import br.shiton.short_link.domain.link.entity.Link;
import br.shiton.short_link.domain.link.factory.LinkFactory;
import br.shiton.short_link.infrastructure.link.repository.mongoDB.LinkEntity;
import br.shiton.short_link.infrastructure.link.repository.mongoDB.LinkRepository;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class CreateLinkUseCase {

    private final LinkRepository repository;

    public CreateLinkUseCase(LinkRepository repository) {
        this.repository = repository;
    }

    public OutputCreateLinkDTO execute(InputCreateLinkDTO input) throws NoSuchAlgorithmException {
        try {
            String urlHash = generateSHA256(input.url());
            String shortUrlHash = urlHash.substring(0, 8);

            String shortUrl = "https://short.link/" + shortUrlHash;

            Link link = LinkFactory.create(input.url(), shortUrl);

            LinkEntity entity = new LinkEntity(
                link.getId(),
                link.getUrl(),
                link.getShortUrl(),
                link.getCreatedAt()
            );

            repository.insert(entity);

            return new OutputCreateLinkDTO(
                entity.getId(),
                entity.getUrl(),
                entity.getShortUrl(),
                entity.getCreatedAt()
            );
        } catch (Exception e){
            System.out.println("Log de erro aqui");
            throw e;
        }
    }

    private static String generateSHA256(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
