<img width="1059" height="802" alt="image" src="https://github.com/user-attachments/assets/70896aef-6585-4c5e-ac16-a9e816ce3c8a" />
## link swagger http://localhost:8080/swagger-ui/index.html 

# Capas de Seguridad La Aplicacion: 
## Filters: "JWTAuthenFilter" capa de autenticacion del usuario y capa de respuesta exitosa de la autenticacion del usuario y generador del token
## Filters: "JWTAuthorizationFilter" segunda capa de autenticacion para el login del usuario, 
## agarra el header token del usuario y obtiene el nombre del usuario por medio del token y revisa si existe en la base de datos, ahi otorga el permiso. 
## Security: "JWTUtilsClass" generacion del token, obtener uno o todos los claims de jwt, , obtencion de firma de la llave de acceso 
## Security: "SecurityConfig" configuracion de los permisos de los endpoints cuando el usuario está o no autenticado, 
## encriptado de contraseña, creacion de usuario en memoria para la autenticacion