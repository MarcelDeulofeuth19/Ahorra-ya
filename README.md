# AhorraYa

APP Android (Java) de la Actividad 5, Módulo 3 – parte individual.

## Propuesta

- **Sector:** educación financiera (fintech).
- **¿Por qué este sector?** En Colombia una parte importante de la población no accede a crédito formal ni tiene hábitos de ahorro, y el celular es el canal más usado para gestionar dinero. Una APP móvil es la forma más directa de llevar formación financiera básica a jóvenes y trabajadores independientes.
- **Idea:** AhorraYa inscribe a usuarios en un programa gratuito de educación financiera de 4 semanas (ahorro, crédito responsable e inversión). El usuario conoce el programa, diligencia el formulario y recibe la confirmación con el resumen de lo que registró.

## Ventanas (Actividades)

| # | Activity | Qué hace |
| --- | --- | --- |
| 1 | `PresentacionActivity` | Logo, nombre, descripción y botón **Comenzar inscripción** |
| 2 | `FormularioActivity` | Nombre, correo, ciudad, rango de ingresos y temas de interés. No guarda nada: envía los datos por `Intent` |
| 3 | `AceptacionActivity` | Muestra los datos escritos y seleccionados; botones **Nueva inscripción** y **Salir** |

## Requisitos de la guía

| Requisito | Cómo se cumple |
| --- | --- |
| Mínimo 4 componentes básicos | `Button`, `TextView`, `ImageView`, `EditText`, `CheckBox` y `RadioButton` (6) |
| Un tipo de panel estudiado | `LinearLayout` vertical en las tres ventanas (dentro de un `ScrollView` en el formulario) |
| Datos sin base de datos | `intent.putExtra(...)` en el formulario y `getStringExtra(...)` en la aceptación |
| Botón salir | `finishAffinity()` + `System.exit(0)` en `AceptacionActivity` |

## Cómo ejecutarla

1. Android Studio → File → Open → carpeta `AhorraYa`.
2. Esperar la sincronización de Gradle.
3. Run ▶ sobre un emulador o un celular (Android 7.0 / API 24 o superior).

Si la sincronización falla por versiones, crear un proyecto nuevo *Empty Views Activity* (Java, minSdk 24, paquete `com.umb.ahorraya`) y copiar encima la carpeta `app/src/main`.

## Subir a GitHub

```bash
git init -b main
git add .
git commit -m "feat: APP AhorraYa con presentación, formulario y aceptación"
git remote add origin https://github.com/MarcelDeulofeuth19/AhorraYa.git
git push -u origin main
```

En GitHub: Settings → Collaborators → agregar al docente.
