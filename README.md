```declarative
curl --location 'localhost:8080/api/v1/links' \
--header 'Content-Type: application/json' \
--header 'Cookie: estocacsrftoken=8RTbMHcu6sjJ76Tc5dv3DheR7UKillzOB3wDRxbVkxwvLLzOBica5aRaqqVJ4quG' \
--data '{
    "url": "https://google.com"
}'
```

```declarative
curl --location 'localhost:8080/api/v1/links/73ecca4a-14fe-4c1b-98b2-390e3cc6ff3a' \
--header 'Cookie: estocacsrftoken=8RTbMHcu6sjJ76Tc5dv3DheR7UKillzOB3wDRxbVkxwvLLzOBica5aRaqqVJ4quG'
```   
