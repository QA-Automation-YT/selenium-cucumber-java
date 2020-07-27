@functional
Feature: Categoria Comics
  Como usuario quiero leer chistes de testers para reirme y pasar un buen rato.

  @browser @slow
  Scenario: Ingresar a la categoria Comics desde la pantalla Home
    Given   El usuario se encuentra en la pagina Home de imalittletester
    When    Hace click sobre el titulo The little tester comics
    Then    Se debe redirigir a la pantalla Comics


  @math
  Scenario Outline: Bebiendo
    Given Hay <inicio> cervezas
    When  Tomo <cantidad> cervezas
    Then  Deberian quedar <resto> cervezas

    @happypath
    Examples:
      | inicio | cantidad | resto |
      | 10     | 5        | 5     |
      | 10     | 10       | 0     |


  Scenario: Docs strings
    Given Un blog llamado "Random" con el siguiente contenido
    """
    Teoria de la tierra en forma de rosquilla
    =================
    Este es el primer parrafo
    """

  Scenario: Data table
    Given Los siguientes usuarios existentes:
      | nombre | email           | twitter |
      | santi  | santi@gmail.com | @santi  |
      | orion  | ori@gmail.com   | @ori    |