# API Restful Express com Postgres DB

A API foi feita utilizando as tecnologias mais recentes que conheço em Apis Rest, microserviços/webservices de pequeno port. Devido a simplicidade dos requisitos, a aquitetura não está tão sofisticada quanto poderia ser ou como um projeto pronto para Produção.

## Como subir a API

Instale as dependências:

> yarn _ou_ npm install

Para instalar o banco de dados por docker (atente-se a senha e portas expostas):

> docker run --name veiculos-postgres -e POSTGRES_PASSWORD=1234 -p 5432:5432 -d postgres

Acesse o container pelo terminal:

> docker exec -ti veiculos-postgres /bin/bash

Em seguida acesse o postgres e crie o banco:

> psql -d postgres -U postgres

> create database veiculos;

Para criar a tabela veiculos, vá até a raiz da API e execute o seguinte comando:

> yarn typeorm migration:run

Antes de finalmente subir a API, transpile o typescript para js:

> yarn build

Agora, finalmente, você pode subir a API com o comando:

> yarn dev:server

Infelizmente tive alguns imprevistos e não consegui finalizar a aplicação SPA, consequentemente não consegui 'containizar' todo o projeto, app e api + db, para subir e expor tudo com docker compose. Isso tornou o processo de subir o projeto bem mais chato, peço desculpas por isso.

Quaisquer dúvdas estou a disposição!
