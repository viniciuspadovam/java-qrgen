# QR Gen

Este projeto é composto por dois módulos principais:

- **Backend**: API REST para geração de QR Codes utilizando Spring Boot e ZXing.
- **Frontend**: Aplicação Angular para consumir a API e exibir o QR Code gerado.

## Backend

O backend é uma API desenvolvida em Java com Spring Boot. Ela recebe um texto via requisição HTTP e retorna a imagem do QR Code correspondente.

### Como executar

1. Certifique-se de ter o Java 21+ instalado.
2. Na pasta `backend`, execute:

   ```sh
   ./mvnw spring-boot:run
   ```

3. A API estará disponível em `http://localhost:8080/api/v1`.

---

## Frontend

O frontend é uma aplicação Angular que permite ao usuário digitar um texto, gerar o QR Code e exibi-lo na tela.

### Como executar

1. Certifique-se de ter o Node.js instalado.
2. Na pasta `frontend`, instale as dependências:

   ```sh
   npm install
   ```

3. Execute o servidor de desenvolvimento:

   ```sh
   ng serve
   ```

4. Acesse `http://localhost:4200` no navegador.

---

## Fluxo de funcionamento

1. O usuário digita um texto no frontend e clica em "Generate QR Code".
2. O frontend faz uma requisição POST para o backend com o texto.
3. O backend gera a imagem do QR Code e retorna como blob.
4. O frontend exibe a imagem gerada na tela.

## Tecnologias / Bibliotecas Usadas

- **Backend**
  - Spring Boot
  - ZXing ("Zebra Crossing")
  - Lombok
  - Maven

- **Frontend**
  - Angular
  - RxJS
  - TypeScript
  - Template-driven forms