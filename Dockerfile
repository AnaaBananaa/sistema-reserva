# Use uma imagem base com Java e Maven pré-instalados
FROM maven:3.8.3-openjdk-17 AS builder

# Copie o código-fonte para dentro do contêiner
WORKDIR /app
COPY . .

# Construa o aplicativo usando o Maven
RUN mvn clean package

# Crie a imagem final baseada no JRE para executar o aplicativo
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=builder /app/target/nome-do-seu-arquivo.jar ./app.jar

# Comando para executar o aplicativo quando o contêiner for iniciado
CMD ["java", "-jar", "app.jar"]