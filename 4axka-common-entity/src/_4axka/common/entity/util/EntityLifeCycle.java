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

import javax.persistence.Embeddable;


@Embeddable
public final class EntityLifeCycle {
    private LifeCycleEventType __type;
    private String __source;
    private Date __timestamp;

    public enum LifeCycleEventType {
        CREATE,
        DESTROY,
        MODIFY,
        ACTIVATE,
        DEACTIVATE;
    }
}
