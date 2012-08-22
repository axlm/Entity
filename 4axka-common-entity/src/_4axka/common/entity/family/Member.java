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
package _4axka.common.entity.family;


import java.io.Serializable;
import java.util.Collection;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import _4axka.common.entity.Person;


public final class Member<ID extends Comparable<ID> & Serializable> extends Person<ID> {
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
    private final ConcurrentSkipListSet<Member<ID>> __spouses = new ConcurrentSkipListSet<>();
    @OneToMany(cascade = {
            CascadeType.ALL
    }, fetch = FetchType.EAGER, mappedBy = "__member")
    private final ConcurrentSkipListSet<Member<ID>> __parents = new ConcurrentSkipListSet<>();
    @OneToMany(cascade = {
            CascadeType.ALL
    }, fetch = FetchType.EAGER, mappedBy = "__member")
    private final ConcurrentSkipListSet<Member<ID>> __siblings = new ConcurrentSkipListSet<>();
    @OneToMany(cascade = {
            CascadeType.ALL
    }, fetch = FetchType.EAGER, mappedBy = "__member")
    private final ConcurrentSkipListSet<Member<ID>> __children = new ConcurrentSkipListSet<>();
    @OneToMany(cascade = {
            CascadeType.ALL
    }, fetch = FetchType.EAGER, mappedBy = "__member")
    private final ConcurrentSkipListSet<Member<ID>> __gaurdians = new ConcurrentSkipListSet<>();
    @JoinColumn(name = "MEMBER_FK", referencedColumnName = "ID")
    private Member<ID> __member;

    public Member() {}

    public Member(final Member<ID> member) {
        addSpouses(member.getSpouses());
        addParents(member.getParents());
        addSiblings(member.getSiblings());
        addChildren(member.getChildren());
        addGuardians(member.getGuardians());
    }

    public Iterable<Member<ID>> getSpouses() {
        return __spouses;
    }

    public void addSpouses(final Iterable<Member<ID>> spouses) {
        for (final Member<ID> spouse_ : spouses) {
            addSpouse(spouse_);
        }
    }

    public void addSpouse(final Member<ID> spouse) {
        final Member<ID> spouse_ = new Member<>(spouse);
        __spouses.add(spouse_);
        spouse.setMember(this);
    }

    public Iterable<Member<ID>> getParents() {
        return __parents;
    }

    public void addParents(final Iterable<Member<ID>> parents) {
        for (final Member<ID> parent_ : parents) {
            addParent(parent_);
        }
    }

    public void addParent(final Member<ID> parent) {
        final Member<ID> parent_ = new Member<>(parent);
        __parents.add(parent_);
        parent.setMember(this);
    }

    public Iterable<Member<ID>> getSiblings() {
        return __siblings;
    }

    public void addSiblings(final Iterable<Member<ID>> siblings) {
        for (final Member<ID> sibling_ : siblings) {
            addSibling(sibling_);
        }
    }

    public void addSibling(final Member<ID> sibling) {
        final Member<ID> sibling_ = new Member<>(sibling);
        __siblings.add(sibling_);
        sibling.setMember(this);
    }

    public Iterable<Member<ID>> getChildren() {
        return __children;
    }

    public void addChildren(final Iterable<Member<ID>> children) {
        for (final Member<ID> child_ : children) {
            addChild(child_);
        }
    }

    public void addChild(final Member<ID> child) {
        final Member<ID> child_ = new Member<>(child);
        __children.add(child_);
        child.setMember(this);
    }

    public Iterable<Member<ID>> getGuardians() {
        return __gaurdians;
    }

    public void addGuardians(final Iterable<Member<ID>> guardians) {
        for (final Member<ID> guardian_ : guardians) {
            addGuardian(guardian_);
        }
    }

    public void addGuardian(final Member<ID> guardian) {
        final Member<ID> guardian_ = new Member<>(guardian);
        __gaurdians.add(guardian_);
        guardian.setMember(this);
    }

    protected void setMember(final Member<ID> member) {
        __member = member;
    }

    public Iterable<Member<ID>> getSisters() {
        final CopyOnWriteArrayList<Member<ID>> result_ = new CopyOnWriteArrayList<>();

        for (Member<ID> sibling_ : getSiblings()) {
            if (sibling_.getGender() == GenderType.FEMALE) {
                result_.add(sibling_);
            }
        }

        return result_;
    }

    public Iterable<Member<ID>> getBrotehrs() {
        final CopyOnWriteArrayList<Member<ID>> result_ = new CopyOnWriteArrayList<>();

        for (Member<ID> sibling_ : getSiblings()) {
            if (sibling_.getGender() == GenderType.MALE) {
                result_.add(sibling_);
            }
        }

        return result_;
    }

    public Iterable<Member<ID>> getGrandParents() {
        final CopyOnWriteArrayList<Member<ID>> result_ = new CopyOnWriteArrayList<>();

        for (final Member<ID> parent_ : getParents()) {
            result_.addAll((Collection<? extends Member<ID>>) parent_.getParents());
        }

        return result_;
    }

    public Iterable<Member<ID>> getGrandMothers() {
        final CopyOnWriteArrayList<Member<ID>> result_ = new CopyOnWriteArrayList<>();

        for (Member<ID> parent_ : getParents()) {
            for (Member<ID> grandParent_ : parent_.getParents()) {
                if (grandParent_.getGender() == GenderType.FEMALE) {
                    result_.add(grandParent_);
                }
            }
        }

        return result_;
    }

    public Iterable<Member<ID>> getGrandFathers() {
        final CopyOnWriteArrayList<Member<ID>> result_ = new CopyOnWriteArrayList<>();

        for (Member<ID> parent_ : getParents()) {
            for (Member<ID> grandParent_ : parent_.getParents()) {
                if (grandParent_.getGender() == GenderType.MALE) {
                    result_.add(grandParent_);
                }
            }
        }

        return result_;
    }

    public Iterable<Member<ID>> getCousins() {
        final CopyOnWriteArrayList<Member<ID>> result_ = new CopyOnWriteArrayList<>();

        for (final Member<ID> parent_ : getParents()) {
            for (final Member<ID> sibling_ : parent_.getSiblings()) {
                result_.addAll((Collection<? extends Member<ID>>) sibling_.getChildren());
            }
        }

        return result_;
    }

    public Iterable<Member<ID>> getCousins(final GenderType gender) {
        final CopyOnWriteArrayList<Member<ID>> result_ = new CopyOnWriteArrayList<>();

        for (final Member<ID> parent_ : getParents()) {
            for (final Member<ID> sibling_ : parent_.getSiblings()) {
                for (Member<ID> cousin_ : sibling_.getChildren()) {
                    if (cousin_.getGender() == gender) {
                        result_.add(cousin_);
                    }
                }
            }
        }

        return result_;
    }

    public Iterable<Member<ID>> getAunts() {
        final CopyOnWriteArrayList<Member<ID>> result_ = new CopyOnWriteArrayList<>();

        for (final Member<ID> parent_ : getParents()) {
            for (Member<ID> sibling_ : parent_.getSiblings()) {
                if (sibling_.getGender() == GenderType.FEMALE) {
                    result_.add(sibling_);
                }
            }
        }

        return result_;
    }

    public Iterable<Member<ID>> getUncles() {
        final CopyOnWriteArrayList<Member<ID>> result_ = new CopyOnWriteArrayList<>();

        for (final Member<ID> parent_ : getParents()) {
            for (Member<ID> sibling_ : parent_.getSiblings()) {
                if (sibling_.getGender() == GenderType.MALE) {
                    result_.add(sibling_);
                }
            }
        }

        return result_;
    }

    public Iterable<Member<ID>> getNices() {
        final CopyOnWriteArrayList<Member<ID>> result_ = new CopyOnWriteArrayList<>();

        for (final Member<ID> sibling_ : getSiblings()) {
            for (final Member<ID> child_ : sibling_.getChildren()) {
                if (child_.getGender() == GenderType.FEMALE) {
                    result_.add(child_);
                }
            }
        }

        return result_;
    }

    public Iterable<Member<ID>> getNephews() {
        final CopyOnWriteArrayList<Member<ID>> result_ = new CopyOnWriteArrayList<>();

        for (final Member<ID> sibling_ : getSiblings()) {
            for (final Member<ID> child_ : sibling_.getChildren()) {
                if (child_.getGender() == GenderType.MALE) {
                    result_.add(child_);
                }
            }
        }

        return result_;
    }
}
