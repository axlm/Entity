// $Id$

/*
 * \u00A9 2012, 4axka (Pty) Ltd.  All rights reserved.
 *
 * The content of Member.java is strictly CONFIDENTIAL.
 *
 * It may not be viewed as a whole, or in part by any unauthorised party unless
 * explicit permission has been granted by an authorised 4axka representative.
 *
 * It may not be reproduced as a whole, or in part by any means unless explicit
 * permission has been granted by an authorised 4axka representative.
 */
package tech.anaxka.common.entity.family;


import java.util.Collection;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import tech.anaxka.common.entity.Person;


public class Member extends Person {
    /**
     * Determines if a de-serialised file is compatible with this class.
     * <p>
     * Maintainers <strong>MUST</strong> change this value if and only if the new version of
     * this class is not compatible with the previous version. It is not necessary to include
     * in first version of the class, but included here as a reminder of its importance.
     * 
     * @see <a href="http://bit.ly/aDUV5">Java Object Serialization Specification</a>.
     */
    private static final long serialVersionUID = -7580026024045997036L;

    @OneToMany(cascade = {
            CascadeType.ALL
    }, fetch = FetchType.EAGER, mappedBy = "__member")
    private final ConcurrentSkipListSet<Member> __spouses = new ConcurrentSkipListSet<>();

    @OneToMany(cascade = {
            CascadeType.ALL
    }, fetch = FetchType.EAGER, mappedBy = "__member")
    private final ConcurrentSkipListSet<Member> __parents = new ConcurrentSkipListSet<>();

    @OneToMany(cascade = {
            CascadeType.ALL
    }, fetch = FetchType.EAGER, mappedBy = "__member")
    private final ConcurrentSkipListSet<Member> __siblings = new ConcurrentSkipListSet<>();

    @OneToMany(cascade = {
            CascadeType.ALL
    }, fetch = FetchType.EAGER, mappedBy = "__member")
    private final ConcurrentSkipListSet<Member> __children = new ConcurrentSkipListSet<>();

    @OneToMany(cascade = {
            CascadeType.ALL
    }, fetch = FetchType.EAGER, mappedBy = "__member")
    private final ConcurrentSkipListSet<Member> __gaurdians = new ConcurrentSkipListSet<>();

    @JoinColumn(name = "MEMBER_FK", referencedColumnName = "ID")
    private Member __member;

    public Member() {}

    public Member(final Member member) {
        addSpouses(member.getSpouses());
        addParents(member.getParents());
        addSiblings(member.getSiblings());
        addChildren(member.getChildren());
        addGuardians(member.getGuardians());
    }

    public Iterable<Member> getSpouses() {
        return __spouses;
    }

    public void addSpouses(final Iterable<Member> spouses) {
        for (final Member spouse_ : spouses) {
            addSpouse(spouse_);
        }
    }

    public void addSpouse(final Member spouse) {
        final Member spouse_ = new Member(spouse);
        __spouses.add(spouse_);
        spouse.setMember(this);
    }

    public Iterable<Member> getParents() {
        return __parents;
    }

    public void addParents(final Iterable<Member> parents) {
        for (final Member parent_ : parents) {
            addParent(parent_);
        }
    }

    public void addParent(final Member parent) {
        final Member parent_ = new Member(parent);
        __parents.add(parent_);
        parent.setMember(this);
    }

    public Iterable<Member> getSiblings() {
        return __siblings;
    }

    public void addSiblings(final Iterable<Member> siblings) {
        for (final Member sibling_ : siblings) {
            addSibling(sibling_);
        }
    }

    public void addSibling(final Member sibling) {
        final Member sibling_ = new Member(sibling);
        __siblings.add(sibling_);
        sibling.setMember(this);
    }

    public Iterable<Member> getChildren() {
        return __children;
    }

    public void addChildren(final Iterable<Member> children) {
        for (final Member child_ : children) {
            addChild(child_);
        }
    }

    public void addChild(final Member child) {
        final Member child_ = new Member(child);
        __children.add(child_);
        child.setMember(this);
    }

    public Iterable<Member> getGuardians() {
        return __gaurdians;
    }

    public void addGuardians(final Iterable<Member> guardians) {
        for (final Member guardian_ : guardians) {
            addGuardian(guardian_);
        }
    }

    public void addGuardian(final Member guardian) {
        final Member guardian_ = new Member(guardian);
        __gaurdians.add(guardian_);
        guardian.setMember(this);
    }

    protected void setMember(final Member member) {
        __member = member;
    }

    public Iterable<Member> getSisters() {
        final CopyOnWriteArrayList<Member> result_ = new CopyOnWriteArrayList<>();

        for (Member sibling_ : getSiblings()) {
            if (sibling_.getGender() == GenderType.FEMALE) {
                result_.add(sibling_);
            }
        }

        return result_;
    }

    public Iterable<Member> getBrotehrs() {
        final CopyOnWriteArrayList<Member> result_ = new CopyOnWriteArrayList<>();

        for (Member sibling_ : getSiblings()) {
            if (sibling_.getGender() == GenderType.MALE) {
                result_.add(sibling_);
            }
        }

        return result_;
    }

    public Iterable<Member> getGrandParents() {
        final CopyOnWriteArrayList<Member> result_ = new CopyOnWriteArrayList<>();

        for (final Member parent_ : getParents()) {
            result_.addAll((Collection<? extends Member>) parent_.getParents());
        }

        return result_;
    }

    public Iterable<Member> getGrandMothers() {
        final CopyOnWriteArrayList<Member> result_ = new CopyOnWriteArrayList<>();

        for (Member parent_ : getParents()) {
            for (Member grandParent_ : parent_.getParents()) {
                if (grandParent_.getGender() == GenderType.FEMALE) {
                    result_.add(grandParent_);
                }
            }
        }

        return result_;
    }

    public Iterable<Member> getGrandFathers() {
        final CopyOnWriteArrayList<Member> result_ = new CopyOnWriteArrayList<>();

        for (Member parent_ : getParents()) {
            for (Member grandParent_ : parent_.getParents()) {
                if (grandParent_.getGender() == GenderType.MALE) {
                    result_.add(grandParent_);
                }
            }
        }

        return result_;
    }

    public Iterable<Member> getCousins() {
        final CopyOnWriteArrayList<Member> result_ = new CopyOnWriteArrayList<>();

        for (final Member parent_ : getParents()) {
            for (final Member sibling_ : parent_.getSiblings()) {
                result_.addAll((Collection<? extends Member>) sibling_.getChildren());
            }
        }

        return result_;
    }

    public Iterable<Member> getCousins(final GenderType gender) {
        final CopyOnWriteArrayList<Member> result_ = new CopyOnWriteArrayList<>();

        for (final Member parent_ : getParents()) {
            for (final Member sibling_ : parent_.getSiblings()) {
                for (Member cousin_ : sibling_.getChildren()) {
                    if (cousin_.getGender() == gender) {
                        result_.add(cousin_);
                    }
                }
            }
        }

        return result_;
    }

    public Iterable<Member> getAunts() {
        final CopyOnWriteArrayList<Member> result_ = new CopyOnWriteArrayList<>();

        for (final Member parent_ : getParents()) {
            for (Member sibling_ : parent_.getSiblings()) {
                if (sibling_.getGender() == GenderType.FEMALE) {
                    result_.add(sibling_);
                }
            }
        }

        return result_;
    }

    public Iterable<Member> getUncles() {
        final CopyOnWriteArrayList<Member> result_ = new CopyOnWriteArrayList<>();

        for (final Member parent_ : getParents()) {
            for (Member sibling_ : parent_.getSiblings()) {
                if (sibling_.getGender() == GenderType.MALE) {
                    result_.add(sibling_);
                }
            }
        }

        return result_;
    }

    public Iterable<Member> getNices() {
        final CopyOnWriteArrayList<Member> result_ = new CopyOnWriteArrayList<>();

        for (final Member sibling_ : getSiblings()) {
            for (final Member child_ : sibling_.getChildren()) {
                if (child_.getGender() == GenderType.FEMALE) {
                    result_.add(child_);
                }
            }
        }

        return result_;
    }

    public Iterable<Member> getNephews() {
        final CopyOnWriteArrayList<Member> result_ = new CopyOnWriteArrayList<>();

        for (final Member sibling_ : getSiblings()) {
            for (final Member child_ : sibling_.getChildren()) {
                if (child_.getGender() == GenderType.MALE) {
                    result_.add(child_);
                }
            }
        }

        return result_;
    }
}
