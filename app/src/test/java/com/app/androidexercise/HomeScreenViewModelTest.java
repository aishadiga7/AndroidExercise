package com.app.androidexercise;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;

import com.app.androidexercise.data.RepositoryImpl;
import com.app.androidexercise.data.network.ApiInterface;
import com.app.androidexercise.domain.error.AppError;
import com.app.androidexercise.domain.error.ErrorCode;
import com.app.androidexercise.domain.home.HomeScreenViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class HomeScreenViewModelTest {

    @Mock
    ApiInterface mApiInterface;
    HomeScreenViewModel mHomeScreenViewModel;
    @Rule
    public InstantTaskExecutorRule mInstantTaskExecutorRule = new InstantTaskExecutorRule();


    @Before
    public void setUp() throws Exception {
        mHomeScreenViewModel = new HomeScreenViewModel(new RepositoryImpl(mApiInterface));

    }

    @Test
    public void shouldReturnErrorOnNullResponse() {
        Mockito.when(mApiInterface.getFeeds()).thenReturn(new MutableLiveData<>(null));
        mHomeScreenViewModel.getListLiveData().observeForever(listItems -> {
        });
        mHomeScreenViewModel.getError().observeForever(__ -> {});
        assertEquals(new AppError(ErrorCode.NULL_RESPOSNSE_FROM_SERVER), mHomeScreenViewModel.getError().getValue());
    }


    @Test
    public void  shouldReturnProperUIListItemsOnSuccessfulAPIResponse(){
        Mockito.when(mApiInterface.getFeeds()).thenReturn(new MutableLiveData<>(Stub.getMockApiResponse()));
        mHomeScreenViewModel.fetchFeeds().observeForever(listItems -> { });
        assertEquals(mHomeScreenViewModel.getListLiveData().getValue(), Stub.mockListItems() );

    }




}