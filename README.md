# E-commerce Pricing Service


## Descripción del proyecto
El **E-commerce Pricing Service** es una aplicación desarrollada con **Spring Boot** que proporciona un servicio REST para consultar el precio aplicable a un producto en una fecha específica para una marca determinada. Este servicio es esencial para plataformas de comercio electrónico que necesitan calcular precios dinámicos basados en diferentes criterios.

### Características principales:
- **Consulta de precios**: Permite obtener el precio aplicable a un producto en función de la fecha, el ID del producto y el ID de la marca.
- **Validación de entradas**: Asegura que los parámetros de entrada (fecha de aplicación, ID del producto y ID de la marca) no sean nulos.
- **Manejo de excepciones**: Gestiona adecuadamente los casos en los que no se encuentra un precio aplicable.
- **Pruebas unitarias**: Incluye un conjunto completo de pruebas unitarias para validar el comportamiento del servicio.
- **Documentación de API**: Proporciona documentación interactiva de la API a través de Swagger UI.
- **Contenerización**: Facilita la implementación y ejecución mediante Docker.

### Arquitectura:
El proyecto sigue una **arquitectura hexagonal (Ports and Adapters)**, lo que mejora la mantenibilidad, testabilidad, flexibilidad y escalabilidad del sistema. Esta arquitectura permite desacoplar el núcleo de la aplicación de los detalles de implementación, facilitando la integración con diferentes tecnologías y adaptadores.

```console
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── tmt/
│   │           └── ecommerce/
│   │               ├── application/
│   │               │   ├── services/
│   │               │   │   └── PriceService.java
│   │               │   └── usecases/
│   │               │       └── FindApplicablePriceUseCaseImpl.java
│   │               ├── domain/
│   │               │   ├── models/
│   │               │   │   ├── ErrorMessage.java
│   │               │   │   └── PriceDto.java
│   │               │   └── ports/
│   │               │       ├── in/
│   │               │       │   └── FindApplicablePriceUseCase.java
│   │               │       └── out/
│   │               │           └── PriceRepositoryPort.java
│   │               └── infrastructure/
│   │                   ├── adapters/
│   │                   │   └── PriceRepositoryAdapter.java
│   │                   ├── controllers/
│   │                   │   └── PriceController.java
│   │                   └── exceptions/
│   │                       └── PriceNotFoundException.java
│   └── resources/
│       └── application.yml
└── test/
    └── java/
        └── com/
            └── tmt/
                └── ecommerce/
                    ├── application/
                    │   └── usecases/
                    │       └── FindApplicablePriceUseCaseImplTest.java
                    ├── infrastructure/
                    │   └── adapters/
                    │       └── PriceRepositoryAdapterTest.java
                    └── PriceServiceTest.java
   ```

### Componentes principales:
- **Controladores REST**: Gestionan las solicitudes HTTP y delegan la lógica de negocio a los casos de uso.
- **Casos de uso**: Implementan la lógica de negocio principal y coordinan las interacciones entre los diferentes componentes.
- **Adaptadores**: Conectan el núcleo de la aplicación con las implementaciones específicas de los puertos, como repositorios y servicios externos.
- **Repositorios**: Gestionan el acceso a la base de datos, utilizando **H2 Database** para almacenamiento en memoria durante las pruebas.
- **Mapeadores**: Transforman entidades de dominio en DTOs y viceversa, facilitando la comunicación entre capas.


### Esquema de la Base de Datos
El esquema de la base de datos para el E-commerce Pricing Service puede ser representado de la siguiente manera:

#### Tablas Principales
- **Brand**: Almacena información sobre las marcas.
- **Product**: Almacena información sobre los productos.
- **Price**: Almacena los precios aplicables a los productos en diferentes fechas y para diferentes marcas.



### Tecnologías utilizadas:
- **Java 21**: Lenguaje de programación principal.
- **Spring Boot**: Framework para el desarrollo de aplicaciones.
- **H2 Database**: Base de datos en memoria para pruebas.
- **Docker**: Contenerización de la aplicación.
- **JUnit 5**: Framework de pruebas unitarias.
- **OpenApi**: Generación y mantenimiento de documentos API.

Este proyecto está diseñado para ser fácilmente extensible y adaptable a diferentes necesidades del negocio, proporcionando una base sólida para el desarrollo de servicios de precios en plataformas de comercio electrónico.



## Documentación de la API
La documentación de la API está disponible en los siguientes enlaces:

- **Definición de API:** [EcommerceAPI.yaml](docs/EcommerceAPI.yaml)

- **Swagger UI:** [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

- **API Docs:** [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)



## Pasos para compilar y desplegar
1. Clona el repositorio:
    ```console
    git clone https://github.com/tatianamejiatoscano/test-ecommerce.git
    cd ecommerce-pricing-service
    ```

2. Construye el proyecto con Maven:
    ```console
    mvn clean install
    ```

3. Construye la imagen Docker:
    ```console
    docker build -t ecommerce-app .
    ```

4. Ejecuta el contenedor Docker:
    ```console
    docker run -p 8080:8080 ecommerce-app
    ```

## Uso
Para consultar el precio aplicable a un producto en una fecha específica para una marca determinada, utiliza el siguiente endpoint:
```console
curl --location --request GET 'http://localhost:8080/price?date=2020-06-14-15.00.00&productId=35455&brandId=1'
 ```
Postman: [ECommerce.postman_collection.json](docs/ECommerce.postman_collection.json)


## Pruebas
Para ejecutar las pruebas unitarias, utiliza el siguiente comando:
```console
mvn test
```

## Concluciones
Se ha implementado siguiendo una base sólida, al ser una aplicación sencilla, se podría realizar una implementación menos compleja, pero me he basado en que puede tener una gran proyección.
Desde mi punto de vista la prueba puede seguir evolucionando, se pueden añadir más funcionalidades, como, introducir mecanismos de caché para mejorar el rendimiento en la recuperación de precios,
añadir seguridad para proteger el endpoint REST, mejorar la gestión de configuraciones a través de perfiles y propiedades y más mejoras.



