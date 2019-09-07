import java.util.Arrays;
import java.util.List;

class Person{

    public  void speak(String msg)
    {
        System.out.println(msg);
    }
};
class Teacher extends Person{

}
class Student extends Person{

}

public class test {
    public static void main(String[] args) {
        List<Person> personList=Arrays.asList(new Teacher(),new Student(),new Teacher());
        for(Person person:personList){
//            if(person.getClass().equals(Teacher.class))
//            {
//                System.out.println(person.getClass());
//                person.speak("I am a teacher!");
//            }
            System.out.println(personList.get(0).getClass() == personList.get(2).getClass());

            System.out.println(personList.get(0).getClass() == personList.get(1).getClass());

           // System.out.println(person.getClass());
        }
    }
}
