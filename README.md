# Servicio creación de usuarios
### Servicio que permite la generación de usuarios y los guarda en base de datos H2

Como prueba se puede utilizar la siguiente estructura

URL POST: http://localhost:8080/usuario
```json
{
  "name": "Edgar González",
  "email": "juan2a@asda2sd.com",
  "password":"Hunter22",
  "phones":[
    {
    "number":"1234567",
    "citycode":"1",
    "contrycode":"57"
    },
    {
    "number":"1234567",
    "citycode":"1",
    "contrycode":"57"
    },
    {
    "number":"1234567",
    "citycode":"1",
    "contrycode":"57"
    }
  ]
}
```
Como resultado se puede obtener el siguiente json

```json
{
    "id": 2,
    "name": "Edgar González",
    "email": "juan2a@asda2sd.com",
    "fechaCreacion": "2019-12-08T15:37:10.699+0000",
    "fechaModificacion": "2019-12-08T15:37:10.699+0000",
    "activo": true
}

```
