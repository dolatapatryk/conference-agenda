# conference-agenda

## How to run

1. Import project in IntellijIDEA and click 'Run'

or

2.

```
cd /PATH/TO/conference-agenda
mvn clean package
java -jar target/conference-agenda-1.0-SNAPSHOT.jar
   ```

By default, it will be used `sample.txt` file (located in the project directory) but
you can specify your own file as program argument e.g.

```
java -jar target/conference-agenda-1.0-SNAPSHOT.jar /PATH/TO/file 
```

## Run tests

```
mvn test
```

## Assumptions

1. Input file is always valid. If number of Talks is out of bounds then exception is thrown.
2. If there is no Talk to schedule after Lunch, we've got a Snack time right away.
3. I assumed that can be a numbers in Talk's title (because there is a such talk in sample input in the document)
4. There cannot be gaps between Talks but can be before Lunch if there is no suitable Talk to place.
5. Talks in input file do not exceed 4 hours (afternoon session duration). If one of them is longer than 4 hours then
   exception is thrown.

## Algorithm
I provided LPT (Longest-processing-time-first) algorithm implementation of scheduler.

The algorithm work as follows:
1. Order the Talks by descending order of their length, such that the longest Talk is first.
2. Schedule Talk in this sequence into a Track. The most suitable Talk, before session end, is scheduled.

Tracks are added as needed.
