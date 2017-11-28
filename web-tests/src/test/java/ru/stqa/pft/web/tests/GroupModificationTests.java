//package ru.stqa.pft.web.tests;
//
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import ru.stqa.pft.web.model.GroupData;
//import ru.stqa.pft.web.model.Groups;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.MatcherAssert.assertThat;
//
///**
// * Created by Admin on 22.10.2017.
// */
//public class GroupModificationTests extends TestBase {
//
//    @BeforeMethod
//    public void ensurePreconditions() {
//        if (app.db().groups().size() == 0) {
//            app.goTo().groupPage();
//            app.group().create();
//        }
//    }
//
//
//    @Test
//    public void testGroupModification() {
//        Groups before = app.db().groups();
//        GroupData modifiedGroup = before.iterator().next();
//        GroupData group = new GroupData()
//                .withId(modifiedGroup.getId()).withName("groupChangedName").withHeader("groupChangedHeader").withFooter("groupChangedFooter");
//        app.goTo().groupPage();
//        app.group().modify(group);
//        assertThat(app.group().count(), equalTo(before.size()));
//        Groups after = app.db().groups();
//        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
//
//        verifyGroupListInUI();
//    }
//
//}
