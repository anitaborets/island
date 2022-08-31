# island
Модель острова с локациями животных и растений

Параметры по умолчанию: остров 10*20 клеток, реализован в виде двумерного массива, в каждой клетке которого хранится ArrayList<Alive> - список сущностей.
Пользователь может задать свои параметры.

Параметры сущностей находятся в пакете entity. Все сущности унаследованы от абстрактного класса Alive, затем животные наследуются от абстрактного класса Animal,растения принадлежат классу Plant.
Передвижение и питание животных реализовано в интерфейсах Activity, Herbivores, Predator. 
  
Животные создаются в классе AnimalCreator, максимальное количество животных ограничено через HashMap<Entities, Integer> maxQuantity.
Передвижение, питание и размножение животных реализовано через добавление/удаление элементов соответствующего локации ArrayList<Alive>.
Животное может выбирать направление движения – в рандомном порядке.

Питание животных разделяется в зависимости от того, является ли животное хищником или травоядным. Хищники едят травоядных, травоядные – траву. Успешность съедания загружается из файла edibility.json.

Животные умеют размножаться, при условии наличия животного такого же типа на клетке, количество детенышей определяется рандомно.
Сбор и вывод статистики реализован в пакете statistic.
Логирование реализовано в пакете logger, лог сохраняется в файл.
Многопоточность реализована в демо-версии 😊 – методы логирования, eat и reproduce работают, но криво.

Пример вывода на экран:

WELCOME TO THE ISLAND!!!

We will create an island with animals, and we will watch how the fittest survive. On our island will live: 
bear, boa, buffalo, caterpillar, deer, duck, eagle, fox, goat, horse, mouse, pig, plant, rabbit, sheep, wolf, 

By default, our island will have dimensions: 
Island dimensions: 3 wight and height: 3
Number of simulation days: 10
Do you want to change this dimensions? Input 1 if you want.


We are starting simulation with default dimensions.
**********************************
WE ARE STARTING!


♒	♒	♒	♒	♒	
♒	☘	Duck	Mouse	♒	
♒	Caterpillar	Caterpillar	☘	♒	
♒	Rabbit	Caterpillar	Wolf	♒	
♒	♒	♒	♒	♒	

1513 entities started. They are:
{Fox=54,Pig=77,Plant=126,Duck=116,Mouse=249,Eagle=47,Bear=13,Rabbit=118,Alive=1513,Wolf=63,Animal=1387,Goat=95,Deer=28,Horse=52,Buffalo=21,Boa=41,Caterpillar=308,Sheep=105}

1277 animals moved 
Some animals were eaten. Left to exist in the population:  1169
1228 entities are after reproducing.
Condition at the end of the day: 
{Fox=52,Pig=69,Plant=1,Duck=103,Mouse=157,Eagle=50,Bear=13,Rabbit=68,Alive=1228,Wolf=70,Animal=1227,Goat=90,Deer=29,Horse=53,Buffalo=21,Boa=133,Caterpillar=189,Sheep=130}

Day 1 is finished
**************
Start new day.Some of the animals died.The population of the island has decreased by: 533
Plant has grown, total Plant: 111
Animals before start new day: 805
They are: 
{Fox=51,Pig=40,Plant=111,Duck=54,Mouse=71,Eagle=48,Bear=12,Rabbit=47,Alive=805,Wolf=32,Animal=694,Goat=49,Deer=12,Horse=24,Buffalo=14,Boa=65,Caterpillar=84,Sheep=91}

//Финальный отчет:

The whole island lived 10 days.
Totally started life on the island: 1513
They were: 
{Fox=54,Pig=77,Plant=126,Duck=116,Mouse=249,Eagle=47,Bear=13,Rabbit=118,Alive=1513,Wolf=63,Animal=1387,Goat=95,Deer=28,Horse=52,Buffalo=21,Boa=41,Caterpillar=308,Sheep=105}
Count of predators was: 218 and Herbivores: 1169
At least, remained on the island: 385
They were: 
{Fox=53,Buffalo=13,Pig=30,Plant=135,Duck=5,Eagle=52,Bear=12,Sheep=61,Rabbit=3,Alive=385,Animal=250,Goat=21}
Count of predators was: 117 and Herbivores: 133
We have the most: Plant=135 and the least: Rabbit=3
These entities are completely extinct: BOA, CATERPILLAR, DEER, HORSE, MOUSE, WOLF, 
That is life... Run again and see who will be the most tenacious!!!



