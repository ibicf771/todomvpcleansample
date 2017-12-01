/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.architecture.android.todo_mvp_sample;

/**
 * Use cases are the entry points to the domain layer.
 * <p>
 * application specific business rules 层，工程内在逻辑层，作用是制定规则（使用线程池）
 * 来执行具体的业务逻辑（本项目中各种task），这个层不能够影响实体类，本地存储的数据和用户UI。
 * 本工程中，这个层包含 {@link UseCase}、{@link UseCaseHandler}和{@link UseCaseScheduler}
 * <p>
 * 在本工程中这个层的实现逻辑是这样的：
 * {@link UseCase} 本层的通用任务。
 * {@link UseCaseHandler} 包装和执行{@link UseCase}，把{@link UseCase}交给{@link UseCaseScheduler}来调度,
 * 注意{@link UseCase}的执行是在这个类中调用的，{@link UseCaseScheduler}只是负责调度，不执行{@link UseCase}。
 * {@link UseCaseScheduler} 负责调度{@link UseCase} 何时执行。
 *
 * @param <Q> the request type
 * @param <P> the response type
 */
public abstract class UseCase<Q extends UseCase.RequestValues, P extends UseCase.ResponseValue> {

    private Q mRequestValues;

    private UseCaseCallback<P> mUseCaseCallback;

    public void setRequestValues(Q requestValues) {
        mRequestValues = requestValues;
    }

    public Q getRequestValues() {
        return mRequestValues;
    }

    public UseCaseCallback<P> getUseCaseCallback() {
        return mUseCaseCallback;
    }

    public void setUseCaseCallback(UseCaseCallback<P> useCaseCallback) {
        mUseCaseCallback = useCaseCallback;
    }

    void run() {
        executeUseCase(mRequestValues);
    }

    protected abstract void executeUseCase(Q requestValues);

    /**
     * Data passed to a request.
     */
    public interface RequestValues {
    }

    /**
     * Data received from a request.
     */
    public interface ResponseValue {
    }

    public interface UseCaseCallback<R> {
        void onSuccess(R response);

        void onError();
    }
}
