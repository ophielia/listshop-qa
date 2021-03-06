package hellocucumber.meg.listshop.uitests.framework;


import hellocucumber.meg.listshop.uitests.pages.list.ListPage;
import hellocucumber.meg.listshop.uitests.pages.list_managment.ListManagementPage;
import hellocucumber.meg.listshop.uitests.pages.dashboard.AccountPage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.*;

import java.util.HashMap;
import java.util.Map;


public class PageProvider {

    private static final Map<PageType, MobileBasePage> pages = new HashMap<>();

    public static final MobileBasePage getPage(PageType type, boolean forceRecreate) {
        if (!forceRecreate && PageType.AnyNavbar.equals(type)) {
            return anyPageWithNavbar();
        }
        if (!forceRecreate && pages.keySet().contains(type)) {
            return pages.get(type);
        }
        return createPage(type);
    }
    public static final MobileBasePage getPage(PageType type) {
        return getPage(type, false);
    }

    private static MobileBasePage anyPageWithNavbar() {
        if (pages.containsKey(PageType.ListPage)) {
            return pages.get(PageType.ListPage);
        } if (pages.containsKey(PageType.Account)) {
            return pages.get(PageType.Account);
        }

        // create account page as default
        pages.put(PageType.Account, new AccountPage());
        return pages.get(PageType.Account);

    }

    private static MobileBasePage createPage(PageType type) {
        switch(type) {
            case Choice:
                pages.put(type, new ChoicePage());
                break;
            case Account:
                pages.put(type, new AccountPage());
                break;
            case ForgotPassword:
                pages.put(type, new ForgotPasswordPage());
                break;
            case PasswordResetSuccess:
                pages.put(type, new PasswordResetSuccessPage());
                break;
            case ListManagementPage:
                pages.put(type, new ListManagementPage());
                break;
            case ListPage:
                pages.put(type, new ListPage());
                break;
            case SignIn:
                pages.put(type, new SignInPage());
                break;
            case SignUp:
                pages.put(type, new SignUpPage());

        }
        return pages.get(type);
    }

    public static SignInPage getSignInPage() {
        return (SignInPage) PageProvider.getPage(PageType.SignIn);
    }
    public static SignInPage refreshSignInPage() {
        return (SignInPage) PageProvider.getPage(PageType.SignIn, true);
    }
    public static SignUpPage getSignUpPage() {
        return (SignUpPage) PageProvider.getPage(PageType.SignUp);
    }

    public static ChoicePage getChoicePage() {
        return (ChoicePage) PageProvider.getPage(PageType.Choice);
    }
    public static ListPage getListPage() {
        return (ListPage) PageProvider.getPage(PageType.ListPage);
    }

    public static ListManagementPage getListManagementPage() {
        return (ListManagementPage) PageProvider.getPage(PageType.ListManagementPage);
    }

    public static AccountPage getAccountPage() {
        return (AccountPage)PageProvider.getPage(PageType.Account);
    }

    public static void reset() {
        pages.clear();
    }
}
