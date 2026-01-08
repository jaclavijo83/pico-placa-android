## FASE 1 – Núcleo lógico

Esta fase implementa el motor central de decisión para Pico y Placa:

- Modelos de dominio:
  - Vehicle
  - PicoPlacaRule
  - TimeWindow
- Motor de validación independiente de Android
- Cálculo de día, hora y tolerancia
- Compatibilidad con múltiples franjas horarias
- Tests unitarios JVM (sin emulador)
- Uso de java.time con desugaring

Esta lógica es estable y no debe modificarse en fases posteriores.
