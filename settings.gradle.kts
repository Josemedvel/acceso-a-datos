rootProject.name = "AccesoADatos"
include("src:main:test")
findProject(":src:main:test")?.name = "test"

include("src:clase-pruebas")