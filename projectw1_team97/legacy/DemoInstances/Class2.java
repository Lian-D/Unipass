package DemoInstances;

import java.util.List;
import java.util.Objects;

public class Class2 {
    private String Name;
    private List<Class1> Class1s;

    public Class2(String name, List<Class1> class1s) {
        Name = name;
        Class1s = class1s;
    }

    public List<Class1> getClass1s() {
        return Class1s;
    }

    public void setClass1s(List<Class1> class1s) {
        Class1s = class1s;
    }

    public void addClass1(Class1 class1){
        if (!Class1s.contains(class1)){
            Class1s.add(class1);
            class1.addClass2(this);
        }

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Class2)) return false;
        Class2 class2 = (Class2) o;
        return Objects.equals(getName(), class2.getName()) &&
                Objects.equals(getClass1s(), class2.getClass1s());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getClass1s());
    }
}
