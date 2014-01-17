package tech.anaxka.common.entity.util;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Embeddable;

/**
 *
 * @author axl.mattheus@4axka.net
 */
@Embeddable
public class EntityLifeCycle implements Serializable {
    private LifeCycleStateType __state;
    private String __source;
    private Date __timestamp;

    public EntityLifeCycle() {
        super();
    }

    public EntityLifeCycle(final LifeCycleStateType state, final String source, final Date timestamp) {
        this();
        __state = state;
        __source = source;
        __timestamp = new Date(timestamp.getTime());
    }

    public LifeCycleStateType getState() {
        return __state;
    }

    public void setState(LifeCycleStateType state) {
        __state = state;
    }

    public String getSource() {
        return __source;
    }

    public void setSource(String source) {
        __source = source;
    }

    public Date getTimestamp() {
        return new Date(__timestamp.getTime());
    }

    public void setTimestamp(final Date timestamp) {
        __timestamp = new Date(timestamp.getTime());
    }

    public enum LifeCycleStateType {
        CREATED    (0, 4, 1, 3),
        MODIFIED   (1, 4, 1, 3),
        ACTIVATED  (2, 4, 1, 3),
        DEACTIVATED(3, 4, 2),
        DESTROYED  (4);
        
        private final int __state;
        private final Set<Integer> __nextStates = new HashSet<>();

        private LifeCycleStateType(final int state, final int... nextEvents) {
            __state = state;
            for (final int event_ : nextEvents) {
                __nextStates.add(event_);
            }
        }

        public Set<LifeCycleStateType> nextStates() {
            final HashSet<LifeCycleStateType> result_ = new HashSet<>();

            for (final LifeCycleStateType state_ : LifeCycleStateType.values()) {
                if (state_.__nextStates.contains(__state)) {
                    result_.add(state_);
                }
            }

            return result_;
        }
    }
}
