# Chat Application with Spring Boot and WebSockets

Este é um projeto  de um aplicativo de bate-papo em tempo real usando Spring Boot e WebSockets. O objetivo deste projeto foi criar uma implementação prática do uso de WebSockets para comunicação bidirecional entre clientes e servidores.
## Funcionalidades
  - **Conexão em Tempo Real**: Os usuários podem se conectar ao servidor WebSocket e enviar/receber mensagens em tempo real.
  - **Notificações de Entrada/Saída**: O servidor notifica todos os clientes quando um novo usuário entra ou sai do chat.
  - **Troca de Mensagens**: Os usuários podem enviar mensagens para o chat, que são retransmitidas para todos os clientes conectados.

## Tecnologias Utilizadas

  - **Spring Boot**: Framework para desenvolvimento de aplicativos Java.
  - **WebSockets**: Protocolo de comunicação bidirecional em tempo real.
  - **STOMP**: Protocolo de mensagens simples sobre WebSockets.
  - **Lombok**: Biblioteca para reduzir a verbosidade do código Java.

### Pré-requisitos

  - Java 17 ou superior
  - Maven
  - IDE de sua preferência (IntelliJ IDEA, VS Code, Eclipse, etc.)

## Configuração do Projeto

1. Clone o repositório:
    ```bash
    git clone https://github.com/seu-usuario/chat-spring-websocket.git
    cd chat-spring-websocket
    ```

2. Instale as dependências:
    Execute o seguinte comando para baixar as dependências do projeto:
    ```bash
    mvn clean install
    ```
3. Execute o projeto:
    Inicie o servidor Spring Boot com o seguinte comando:
   ```bash
   mvn spring-boot:run
   ```
# Documentação dos Endpoints - ChatController

## Visão Geral
A classe `ChatController` é um controlador WebSocket que gerencia a troca de mensagens em um chat em tempo real. Ela possui dois endpoints principais:
- Envio de mensagens.
- Adição de um usuário ao chat.

## Endpoints

### Enviar Mensagem
**Rota:** `/chat.sendMessage`  
**Tipo:** WebSocket Message  
**Descrição:** Recebe uma mensagem de chat e a envia para o tópico público do WebSocket.

#### Parâmetros de Entrada
| Nome         | Tipo          | Descrição |
|-------------|--------------|------------|
| chatMessage | `ChatMessage` | Objeto contendo a mensagem enviada pelo usuário. |

#### Corpo da Requisição (`ChatMessage`)
```json
{
    "sender": "Nome do Usuário",
    "content": "Texto da mensagem",
    "timestamp": "2025-02-16T12:34:56Z"
}
```

#### Resposta
**Código:** 200 OK  
**Conteúdo:** A mesma mensagem enviada pelo usuário é retornada para todos os inscritos no tópico `/topic/public`.

```json
{
    "sender": "Nome do Usuário",
    "content": "Texto da mensagem",
    "timestamp": "2025-02-16T12:34:56Z"
}
```

### Adicionar Usuário
**Rota:** `/chat.addUser`  
**Tipo:** WebSocket Message  
**Descrição:** Adiciona o nome do usuário na sessão do WebSocket.

#### Parâmetros de Entrada
| Nome         | Tipo          | Descrição |
|-------------|--------------|------------|
| chatMessage | `ChatMessage` | Objeto contendo os dados do usuário que será adicionado. |
| headerAcessor | `SimpMessageHeaderAccessor` | Acessor dos cabeçalhos da sessão do WebSocket. |

#### Corpo da Requisição (`ChatMessage`)
```json
{
    "sender": "Nome do Usuário",
    "content": "Entrou no chat",
    "timestamp": "2025-02-16T12:34:56Z"
}
```

#### Resposta
**Código:** 200 OK  
**Conteúdo:** Retorna o objeto `ChatMessage` contendo os dados do usuário adicionado.

```json
{
    "sender": "Nome do Usuário",
    "content": "Entrou no chat",
    "timestamp": "2025-02-16T12:34:56Z"
}
```

