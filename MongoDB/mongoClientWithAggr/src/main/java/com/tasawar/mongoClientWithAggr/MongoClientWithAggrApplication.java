package com.tasawar.mongoClientWithAggr;

import com.tasawar.mongoClientWithAggr.entities.Bird;
import com.tasawar.mongoClientWithAggr.entities.Goat;
import com.tasawar.mongoClientWithAggr.entities.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MongoClientWithAggrApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MongoClientWithAggrApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Object person  = new Person();
//        Field[] fields = person.getClass().getDeclaredFields();
//        System.out.println(getFieldNames(fields));


////        Object goat = new Goat();
//        Object goat = Class.forName("com.tasawar.mongoClientWithAggr.entities.Goat");
//        Class<?> clazz = goat.getClass();
//        System.out.println(clazz.getName());
////        System.out.println(clazz.getAnnotatedInterfaces());
//        System.out.println(clazz.getSimpleName());
//        System.out.println(clazz.getCanonicalName());
//        System.out.println("App is running successfully");

        Class<?> goatClass = Class.forName("com.tasawar.mongoClientWithAggr.entities.Goat");
        Class<?> animalClass = Class.forName("com.tasawar.mongoClientWithAggr.entities.Animal");
        // GET MODIFIERS
//        int goatModifiers = goatClass.getModifiers();
//        int animalModifiers = animalClass.getModifiers();
//
//        System.out.println(Modifier.isPublic(goatModifiers));
//        System.out.println(Modifier.isPrivate(animalModifiers));
        //GET PACKAGE NAME
//        Package goatPackage = goatClass.getPackage();
//        Package animalPackage = animalClass.getPackage();
//        System.out.println(goatPackage.getName());
//        System.out.println(animalPackage.getName());

        //GET SUPER CLASS
//        System.out.println(goatClass.getSuperclass().getSimpleName());
//        System.out.println(animalClass.getSuperclass().getSimpleName());

        // GET INTERFACES
//        Class<?>[] goatInterfaces = goatClass.getInterfaces();
//        Class<?>[] animalInterfaces = goatClass.getSuperclass().getInterfaces();
//        Arrays.stream(goatInterfaces).forEach(inter->System.out.println(inter.getSimpleName()));
//        Arrays.stream(animalInterfaces).forEach(inter-> System.out.println(inter.getSimpleName()));
        //GET CONSTRUCTORS
//        Constructor<?>[] goatConstructors = goatClass.getConstructors();
//        Constructor<?>[] animalConstructors = goatClass.getSuperclass().getConstructors();
//        Arrays.stream(goatConstructors).forEach(cons-> System.out.println(cons.getName()));
//        Arrays.stream(animalConstructors).forEach(cons-> System.out.println(cons.getName()));

        // GET FIELDS
//        Field[] goatFields = goatClass.getDeclaredFields();
//        Field[] animalFields = animalClass.getDeclaredFields();
//        Arrays.stream(goatFields).forEach(field -> System.out.println(field.getName()));
//        Arrays.stream(animalFields).forEach(field -> System.out.println(field.getName()));
        // GET METHODS
//        Method[] goatClassDeclaredMethods = goatClass.getDeclaredMethods();
//        Method[] animalClassDeclaredMethods = animalClass.getDeclaredMethods();
//        Arrays.stream(goatClassDeclaredMethods).forEach(method -> System.out.println(method.getName()));
//        Arrays.stream(animalClassDeclaredMethods).forEach(method -> System.out.println(method.getName()));

        // INSPECTING CONSTRUCTORS

//        givenClass_whenGetsEachConstructorByParamTypes_thenCorrect();
//        givenClass_whenInstantiatesObjectsAtRuntime_thenCorrect();
        givenClassField_whenSetsAndGetsValue_thenCorrect();
    }
    public void givenClass_whenGetsEachConstructorByParamTypes_thenCorrect(){
        Class<?> birdClass = null;
        try {
            birdClass = Class.forName("com.tasawar.mongoClientWithAggr.entities.Bird");
            Constructor<?> cons1 = birdClass.getConstructor();
            Constructor<?> cons2 = birdClass.getConstructor(String.class);
            Constructor<?> cons3 = birdClass.getConstructor(String.class, boolean.class);
            System.out.println(cons3);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }


    }
    public void givenClassField_whenSetsAndGetsValue_thenCorrect() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> birdClass = Class.forName("com.tasawar.mongoClientWithAggr.entities.Bird");
        Bird bird = (Bird) birdClass.getConstructor().newInstance();
        Field field = birdClass.getDeclaredField("walks");
        field.setAccessible(true);

        System.out.println(field.getBoolean(bird));
        field.set(bird,true);
        System.out.println(field.getBoolean(bird));
//        assertFalse(bird.walks());
//
//        field.set(bird, true);
//
//        assertTrue(field.getBoolean(bird));
//        assertTrue(bird.walks());
    }
    public void givenClass_whenInstantiatesObjectsAtRuntime_thenCorrect() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> birdClass = Class.forName("com.tasawar.mongoClientWithAggr.entities.Bird");
        Constructor<?> cons1 = birdClass.getConstructor();
        Constructor<?> cons2 = birdClass.getConstructor(String.class);
        Constructor<?> cons3 = birdClass.getConstructor(String.class,
                boolean.class);

        Bird bird1 = (Bird) cons1.newInstance();
        Bird bird2 = (Bird) cons2.newInstance("Weaver bird");
        Bird bird3 = (Bird) cons3.newInstance("dove", true);

        System.out.println(bird2.eats());
    }
    private static List<String> getFieldNames(Field[] fields) {
        List<String> fieldNames = new ArrayList<>();
        for (Field field : fields)
            fieldNames.add(field.getName());
        return fieldNames;
    }
    private static List<String> getMethodNames(Method[] methods) {
        List<String> methodNames = new ArrayList<>();
        for (Method method : methods)
            methodNames.add(method.getName());
        return methodNames;
    }
}
