package com.arpa.and.base.arch.di.module;

import com.arpa.and.base.arch.data.DataRepository;
import com.arpa.and.base.arch.data.IDataRepository;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@InstallIn(SingletonComponent.class)
@Module
public abstract class RepositoryModule {

    @Binds
    abstract IDataRepository bindDataRepository(DataRepository dataRepository);
}
