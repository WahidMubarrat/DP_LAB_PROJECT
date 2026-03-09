# Racing In IUT

A console-based single-player racing game built in Java. The player selects a car, tunes its engine and turbocharger, picks a track, chooses a race type, and applies a NOS boost at the pit stop — all driven through an interactive menu. The project is structured around six classic Gang-of-Four design patterns, each solving a concrete problem in the game's architecture.

---

## How to Run

```bash
javac -encoding UTF-8 -d out -sourcepath src src\racing\Rii.java
java -cp out racing.Rii
```

---

## Game Flow

```
1. Enter player name
2. Choose car category    →  Coupe  |  Roadster
3. Choose specific car    →  Toyota GR86 / Subaru BRZ  |  Porsche Boxster / Ferrari 812
4. Tune the car
       Choose engine      →  V6  |  V8  |  V12
       Choose turbo       →  Alpine  |  Cummins  |  Honeywell
5. Choose track           →  Blue Moon Bay Speedway  |  BB Raceway  |  Circuit de Spa-Francorchamps
6. Choose race type       →  Sprint (point-to-point)  |  Circuit (full lap)
7. Choose NOS brand       →  Resonac NOS  |  Sema NOS
8. Race runs automatically (fixed sequence — see Template Method below)
9. Player stats printed
```

---

## Design Patterns

### 1. Singleton — `Player`

Only one `Player` instance is allowed per game session. Implemented with double-checked locking (`volatile` + `synchronized`) for thread safety. The player's name and race count persist across calls through the singleton reference.

```
Player.getInstance("name")  →  creates on first call, returns same instance on every subsequent call
```

---

### 2. Abstract Factory — `CarFactory`

The car catalogue is split into families. `CarFactory` is the interface; `CoupeFactory` and `RoadsterFactory` are the concrete factories. Game code only interacts with the `CarFactory` interface — it never knows which concrete factory it holds.

```
CarFactory (interface)
 ├── CoupeFactory    →  ToyotaGR86, SubaruBRZ
 └── RoadsterFactory →  PorscheBoxster, Ferrari812
```

---

### 3. Factory — `TrackFactory` & `RaceFactory`

Static factory methods centralise the creation of tracks and race types. Neither `TrackFactory` nor `RaceFactory` can be instantiated — both are utility classes with only static methods.

```
TrackFactory.createTrack(n)     →  BlueMoonBaySpeedway | BBRaceway | CircuitDeSpaFrancorchamps
RaceFactory.createRace(n, nos)  →  SprintRace | CircuitRace
```

---

### 4. Strategy — Engine & Turbocharger Behaviours

`Car` holds two strategy references — one for engine behaviour and one for turbocharger behaviour. Both can be swapped at runtime without touching the car class.

```
EngineBehavior (interface)
 ├── V6Engine
 ├── V8Engine
 └── V12Engine

TurbochargerBehavior (interface)
 ├── AlpineTurbocharger
 ├── CumminsTurbocharger
 └── HoneywellTurbocharger
```

After the player tunes their car (step 4), the engine and turbocharger slots are swapped live on the `Car` object — demonstrating that strategies are interchangeable objects, not hardcoded behaviour.

---

### 5. Decorator — NOS at Pit Stop

`CarDecorator` wraps any `Car` and delegates every base method to it. Concrete decorators (`ResonacNOS`, `SemaNOS`) add the `applyNOS()` behaviour on top. The race receives a plain `Car` before the pit stop, wraps it in a decorator, and then calls `applyNOS()` on the result — the car itself is completely unmodified.

```
Car (abstract)
 └── CarDecorator  (wraps Car, delegates all methods)
      ├── ResonacNOS  →  "Resonac N2O flooding the intake manifold..."
      └── SemaNOS     →  "Direct-port injection — instantaneous torque explosion!"
```

---

### 6. Template Method — `Race`

`Race.race()` is declared `final`. It defines the canonical race sequence and cannot be overridden. Subclasses provide exactly two abstract hooks:

- `pitStop(Car)` — announce pit stop, return NOS-decorated car
- `finishLine(Track)` — describe how this race type ends

```
race() — final sequence
  a) carInfo
  b) trackInfo
  c) start car          (car.start → engine fires)
  d) start line         (track.startLine)
  e) full throttle      (car.accelerate → turbo fires)
  f) pit stop           ← hook: subclass wraps car in NOS decorator
  g) NOS activated      (nos.applyNOS)
  h) finish line        ← hook: Sprint = far end | Circuit = back at start
  i) stop car
  j) lap time           (random, formatted HH:mm:ss)
```

| Subclass | Pit stop message | Finish line behaviour |
|---|---|---|
| `SprintRace` | Pulling into the pit lane | Finish at far end of track |
| `CircuitRace` | Entering the pit box | Finish back at the start (full lap) |

---

## Project Structure

```
src/racing/
 ├── Rii.java                        Entry point — orchestrates all patterns
 ├── car/
 │    ├── Car.java                   Abstract base — holds Strategy references
 │    ├── Coupe.java                 Abstract sub-category
 │    ├── Roadster.java              Abstract sub-category
 │    ├── ToyotaGR86.java
 │    ├── SubaruBRZ.java
 │    ├── PorscheBoxster.java
 │    └── Ferrari812.java
 ├── decorator/
 │    ├── CarDecorator.java          Abstract decorator — delegates to wrapped Car
 │    ├── ResonacNOS.java
 │    └── SemaNOS.java
 ├── factory/
 │    ├── CarFactory.java            Abstract Factory interface
 │    ├── CoupeFactory.java
 │    ├── RoadsterFactory.java
 │    ├── TrackFactory.java          Static Factory
 │    └── RaceFactory.java          Static Factory
 ├── race/
 │    ├── Race.java                  Template Method — final race() sequence
 │    ├── SprintRace.java
 │    └── CircuitRace.java
 ├── singleton/
 │    └── Player.java                Double-checked locking Singleton
 ├── strategy/
 │    ├── EngineBehavior.java        Strategy interface
 │    ├── TurbochargerBehavior.java  Strategy interface
 │    ├── V6Engine.java
 │    ├── V8Engine.java
 │    ├── V12Engine.java
 │    ├── AlpineTurbocharger.java
 │    ├── CumminsTurbocharger.java
 │    └── HoneywellTurbocharger.java
 └── track/
      ├── Track.java                 Abstract base
      ├── BlueMoonBaySpeedway.java
      ├── BBRaceway.java
      └── CircuitDeSpaFrancorchamps.java
```

---

## Class Hierarchy

```
Car (abstract)
 ├── Coupe (abstract)     → ToyotaGR86, SubaruBRZ
 ├── Roadster (abstract)  → PorscheBoxster, Ferrari812
 └── CarDecorator (abstract, wraps Car)
      ├── ResonacNOS
      └── SemaNOS

Track (abstract) → BlueMoonBaySpeedway, BBRaceway, CircuitDeSpaFrancorchamps

Race (abstract)  → SprintRace, CircuitRace
```

---

## Technical Notes

- `new` is used only for `Scanner` in `main`. All other objects are created through factory methods or private helpers, keeping `main` free of construction logic.
- `Race.race()` is `final` — the sequence is locked; only the two hook methods can vary per subclass.
- `CarDecorator` inherits from `Car` so a decorated car can be passed anywhere a plain `Car` is expected. All base methods delegate to the wrapped instance; `applyNOS()` is the only new capability.
- `Player` uses `volatile` on the instance field to prevent instruction-reordering issues under double-checked locking.
- Lap time is a random value between 1:00 and 10:00, formatted in `HH:mm:ss` using UTC timezone to avoid offset issues.

---

## Technologies

- **Language:** Java (standard library only, no external dependencies)
- **Build:** `javac` + `run.bat`
- **Patterns:** Singleton, Abstract Factory, Factory, Strategy, Decorator, Template Method
