package yaklyushkin_otus.spring_2019_02.hw05.helpers;

import java.util.Objects;

public class StringDataHolder {

    public StringDataHolder(String value, boolean isNeedToChange) {
        this.value = value;
        this.isNeedToChange = isNeedToChange;
    }

    public String getValue() {
        return value;
    }

    public boolean isNeedToChange() {
        return isNeedToChange;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other == null) ||
            (getClass() != other.getClass())) {
            return false;
        }
        StringDataHolder that = (StringDataHolder) other;
        return (isNeedToChange == that.isNeedToChange) &&
               (Objects.equals(value, that.value));
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, isNeedToChange);
    }

    @Override
    public String toString() {
        return "StringDataHolder{" +
                "value='" + value + '\'' +
                ", isNeedToChange=" + isNeedToChange +
                '}';
    }

    private final String value;

    private final boolean isNeedToChange;
}
