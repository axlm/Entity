/* 
 * Copyright © 2011, 4axka (Pty) Ltd
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those
 * of the authors and should not be interpreted as representing official policies,
 * either expressed or implied, of the FreeBSD Project.
 */
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
