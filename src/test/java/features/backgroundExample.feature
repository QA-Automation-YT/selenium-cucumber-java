#Feature: Soporte multiples del sitio
#  Solo los propietarios de blogs pueden publicar en un blog, excepto los administradores, quién puede publicar en todos los blogs.
#
#  Background:
#    Given un administrador global llamado "Greg"
#    And   un blog llamado "despotricaciones anti-impuestos de Greg"
#    And   un cliente llamado "Dr. Bill"
#    And   un blog llamado "Terapia costosa" propiedad del "Dr. Bill"
#
#  Scenario: el Dr. Bill publica en su propio blog
#    Given que he iniciado sesión como Dr. Bill
#    When  trato de publicar en "Terapia costosa"
#    Then  debería ver "Tu artículo fue publicado".
#
#  Scenario: el Dr. Bill intenta publicar en el blog de otra persona y falla
#    Given que he iniciado sesión como Dr. Bill
#    When  trato de publicar en "despotricaciones anti-impuestos de Greg"
#    Then  debería ver "¡Hey! ¡Ese no es tu blog!"
#
#  Scenario: Greg publica en el blog de un cliente
#    Given que he iniciado sesión como Greg
#    When  trato de publicar en "Terapia costosa"
#    Then  debería ver "Tu artículo fue publicado".