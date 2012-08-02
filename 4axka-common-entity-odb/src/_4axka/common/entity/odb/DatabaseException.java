// $Id$

/*
 * \u00A9 2012, 4axka (Pty) Ltd. All rights reserved. The content of DatabaseException.java is
 * strictly CONFIDENTIAL. It may not be viewed as a whole, or in part by any unauthorised party
 * unless explicit permission has been granted by an authorised 4axka representative. It may
 * not be reproduced as a whole, or in part by any means unless explicit permission has been
 * granted by an authorised 4axka representative.
 */
package _4axka.common.entity.odb;


public class DatabaseException extends Exception {
    /**
     * Determines if a de-serialised file is compatible with this class.
     * <p>
     * Maintainers <strong>MUST</strong> change this value if and only if the new version of
     * this class is not compatible with the previous version. It is not necessary to include
     * in first version of the class, but included here as a reminder of its importance.
     * 
     * @see <a href="http://bit.ly/aDUV5">Java Object Serialization Specification</a>.
     */
    private static final long serialVersionUID = 5188519694006590443L;
}
