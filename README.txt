Se utilizaron estos usuarios con sus debidos roles:
Repositor -> repositor (a nivel realm y cliente en api-gateway-client)
Vendedor -> vendedor (a nivel realm y cliente en api-gateway-client)
Administrador -> administrador (a nivel realm -compuesto por repositor y vendedor-, a nivel cliente del api-gateway-client y del administrador-usuarios)
Funcionan todas las operaciones CRUD, para poder utilizar Postman se debe activar la opción "Direct access grants" del api-gateway-client (y evidentemente obtener el token de los usuarios)
Para la base de datos se utilizó h2, el nombre de la base de datos es parcial1
