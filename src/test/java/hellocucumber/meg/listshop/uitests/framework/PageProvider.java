package hellocucumber.meg.listshop.uitests.framework;


import hellocucumber.meg.listshop.uitests.pages.dashboard.AccountPage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.ChoicePage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.ForgotPasswordPage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.SignInPage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.SignUpPage;

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

    public static AccountPage getAccountPage() {
        return (AccountPage)PageProvider.getPage(PageType.Account);
    }
}
