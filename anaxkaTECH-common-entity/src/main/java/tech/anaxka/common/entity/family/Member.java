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

    public final void addSpouses(final Iterable<Member> spouses) {
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

    public final void addParents(final Iterable<Member> parents) {
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

    public final void addSiblings(final Iterable<Member> siblings) {
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

    public final void addChildren(final Iterable<Member> children) {
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

    public final void addGuardians(final Iterable<Member> guardians) {
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
