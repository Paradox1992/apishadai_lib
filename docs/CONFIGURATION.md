# Configuracion de ShApi

Este proyecto no debe versionar archivos locales con rutas, URLs internas o secretos.

## URL base de la API Laravel

La clave requerida por el cliente HTTP es:

```properties
urlapiserver.dev=https://api.ejemplo.test/api
```

Opciones recomendadas, en orden de prioridad:

1. Variable de entorno:

```powershell
$env:APISHADAI_URLAPISERVER_DEV="https://api.ejemplo.test/api"
```

2. Propiedad JVM:

```powershell
java -Dapishadai.config.urlapiserver.dev="https://api.ejemplo.test/api" -jar apishadai.jar
```

3. Archivo externo:

```powershell
java -Dapishadai.config.file="C:\ruta\segura\shapi.properties" -jar apishadai.jar
```

El archivo externo debe usar claves planas como `urlapiserver.dev`.

## Configuracion local ignorada

Los archivos locales `src/con_local.properties` y `src/con_serve.properties` usan el mismo formato plano:

```properties
urlapiserver.dev=http://127.0.0.1:8000/api
```

Estos archivos estan ignorados por Git para que cada entorno pueda tener sus propias URLs.

## CryptoManager

`CryptoManager` ya no contiene una clave fallback embebida. Si se usa cifrado para otro flujo, se debe definir una clave fuera del codigo:

```powershell
$env:APISHADAI_CRYPTO_SECRET="clave-larga-y-privada"
```

## Archivos ignorados

Estos archivos/directorios no deben subirse:

```gitignore
/build
/dist
/nbproject/private/
/src/con_*.properties
*.log
*.log.*
*.lck
```
