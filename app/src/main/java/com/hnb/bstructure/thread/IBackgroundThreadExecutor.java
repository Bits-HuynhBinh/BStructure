/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.hnb.bstructure.thread;


public interface IBackgroundThreadExecutor
{
    /**
     * Executes a {@link Runnable}.
     * @param runnable The class that implements {@link Runnable} interface.
     */
    void execute(final Runnable runnable);
}
