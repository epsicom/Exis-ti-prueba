Feature: Funcionalidad de búsqueda
@wip
  Scenario: Buscar una palabra y comprobar los resultados
    Given que estoy en la página de inicio de búsqueda de Google
    When busco la palabra "automatización"
    And hago clic en el enlace de Wikipedia de los resultados de búsqueda
    Then veo que el primer proceso automático se realizó en "300 a. C"

