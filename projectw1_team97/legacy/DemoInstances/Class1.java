package DemoInstances;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Class1 {
    private String Name;
    private List<Class2> Class2s;

    public Class1(String name, List<Class2> class2s) {
        Name = name;
        Class2s = class2s;
    }

    public List<Class2> getClass2s() {
        return Class2s;
    }

    public void setClass2s(List<Class2> class2s) {
        Class2s = class2s;
    }

    public void addClass2(Class2 class2){
        if (!Class2s.contains(class2)){
            Class2s.add(class2);
            class2.addClass1(this);

        }

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Class1)) return false;
        Class1 class1 = (Class1) o;
        return Objects.equals(getName(), class1.getName()) &&
                Objects.equals(getClass2s(), class1.getClass2s());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getClass2s());
    }
}

