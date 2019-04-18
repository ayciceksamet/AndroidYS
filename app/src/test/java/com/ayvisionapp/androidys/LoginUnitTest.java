package com.ayvisionapp.androidys;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

//@RunWith(MockitoJUnitRunner.class)
public class LoginUnitTest {

    @Mock
    Context mMockContext;

    @Test
    public void readLoginAuth_LoginActivity() {

        LoginActivity myObjectUnderTest = new LoginActivity(mMockContext);

        // ...when the string is returned from the object under test...
        Boolean result = myObjectUnderTest.validateLogin("admin","admin");

        assertThat(result, is(true));
    }


    @Test
    public void readLoginAuthPasswordEmpty_LoginActivity() {

        LoginActivity myObjectUnderTest = new LoginActivity(mMockContext);

        // ...when the string is returned from the object under test...
        Boolean result = myObjectUnderTest.validateLogin("admin","");

        assertThat(result, is(false));
    }


    @Test
    public void readLoginAuthUsernameEmpty_LoginActivity() {

        LoginActivity myObjectUnderTest = new LoginActivity(mMockContext);

        // ...when the string is returned from the object under test...
        Boolean result = myObjectUnderTest.validateLogin("","admin");

        assertThat(result, is(false));
    }



}
