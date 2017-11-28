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
//public class GroupDeletionTests extends TestBase {
//    @BeforeMethod
//    public void ensurePreconditions() {
//        if (app.db().groups().size() == 0) {
//            app.goTo().groupPage();
//            app.group().create();
//        }
//    }
//
//    @Test
//    public void testGroupDeletion() {
//        Groups before = app.db().groups();
//        GroupData deletedGroup = before.iterator().next();
//        app.goTo().groupPage();
//        app.group().delete(deletedGroup);
//        assertThat(app.group().count(), equalTo(before.size() - 1));
//        Groups after = app.db().groups();
//        assertThat(after, equalTo(before.without(deletedGroup)));
//    }
//
//}
