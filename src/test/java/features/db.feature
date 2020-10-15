@functional
Feature: MongoDB
  Como QA Automation Engineer quiero acceder a la base de datos Mongo para verificar el backend de la aplicación

  @backend
  Scenario Outline: Conectarse a la base de datos mipcgamer y verificar los componentes
    Given Me he conectado a la base de datos mipcgamer
    When  Obtengo la PC de QA Automation
    Then  Debo obtener los siguientes componentes "<mother>" "<cpu>" "<memory1>" "<memory2>"

    Examples:
      |mother                     | cpu                  | memory1              |  memory2              |
      |Gigabyte Aorus elite b450  | Ryzen 5 3600 4.2 GHz | HyperX Fury DDR4 8GB | HyperX Fury DDR4 8GB  |
