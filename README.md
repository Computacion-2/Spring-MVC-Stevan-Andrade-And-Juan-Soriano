# Spring-MVC-Stevan-Andrade-And-Juan-Soriano

## Acceso inicial

Al iniciar, la aplicación garantiza una cuenta de prueba fija con usuario `user` y contraseña
`passwordTest`, asociada al rol `USER`. Si ya existe, conserva la misma contraseña; si el hash
guardado no coincide, lo actualiza para que la cuenta de prueba mantenga esas credenciales.
La contraseña se guarda cifrada en la base de datos. Estas credenciales son solo para desarrollo:
no las uses en producción.

Inicia sesión en `/mvc/auth/login`. Después del inicio de sesión, la lista está disponible en
`/app/users`.
