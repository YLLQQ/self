package cglib;

import java.beans.PropertyChangeListener;

/**
 * cglib.Bean
 *
 * @author eleven
 * @date 2019/04/18
 */
public abstract class Bean implements java.io.Serializable {

    String sampleProperty;

    abstract public void addPropertyChangeListener(PropertyChangeListener listener);

    abstract public void removePropertyChangeListener(PropertyChangeListener listener);

    public String getSampleProperty() {
        return sampleProperty;
    }

    public void setSampleProperty(String value) {
        this.sampleProperty = value;
    }

    @Override
    public String toString() {
        return "sampleProperty is " + sampleProperty;
    }

}
