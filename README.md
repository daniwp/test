## Triangles

---
### Statig Code Analysis of Triangle program

#### a) Install Metrics software in your IDE (see tool examples in slides)
Done

#### b) Check coding standards in your Triangle program
```
1>------ Rebuild All started: Project: Triangles, Configuration: Debug Any CPU ------
1>  Triangles -> Triangles.exe
1>  Running Code Analysis...
1>  Code Analysis Complete -- 0 error(s), 0 warning(s)
========== Rebuild All: 1 succeeded, 0 failed, 0 skipped ==========
```

#### c) Calculate central metrics in your Triangle program
![Central Metrics](http://i.imgur.com/N64E56X.png "Central Metrics")

#### d) Find out what CC variation that your metrics tool uses
The Code Metrics tool in Visual Studio 2015 uses CC1. This is a fact because booleans do not increase the cyclomatic complexity, 
but every conditional (if/switch) does.

###### Pros
- Provides a graphical user interface.
- Checks the triangle type, by comparing the length of the sides.
- Checks whether the input is an 32-bit Integer.
- The code is easily readable.

###### Cons
- Doesn't check if the sides can actually form a triangle.
- Calculation logic is not seperated from the Main class.

#### Coding Standard Document
- Follow a specific code style
- Consistent indentation
- Consistent line breaks
- Block grouping
- Consistent variable naming
- Consistent class naming
- Consistent file naming
- DRY Principle
- Return early instead of deep nesting
- Class/method documentation



