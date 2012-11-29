// $Id$

/*
 * \u00A9 2012, 4axka (Pty) Ltd.  All rights reserved.
 *
 * The content of LifeCycle.java is strictly CONFIDENTIAL.
 *
 * It may not be viewed as a whole, or in part by any unauthorised party unless
 * explicit permission has been granted by an authorised 4axka representative.
 *
 * It may not be reproduced as a whole, or in part by any means unless explicit
 * permission has been granted by an authorised 4axka representative.
 */

package _4axka.common.entity.util;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embeddable;


@Embeddable
public final class EntityLifeCycle {
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
        __timestamp = timestamp;
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
        return __timestamp;
    }

    public void setTimestamp(Date timestamp) {
        __timestamp = timestamp;
    }

    public enum LifeCycleStateType {
        CREATED(0, 1, 2, 4),
        DESTROYED(1),
        MODIFIED(2, 2, 4),
        ACTIVATED(3, 1, 2, 4),
        DEACTIVATED(4, 3, 1);

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
