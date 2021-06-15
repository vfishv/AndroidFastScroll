/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.zhanghai.android.fastscroll.sample;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;
import java.io.InputStream;

public class License {

    @Nullable
    private static String sLicense;

    private License() {}

    @NonNull
    public static String get(@NonNull Context context) {
        if (sLicense == null) {
            try (InputStream inputStream = context.getResources().openRawResource(R.raw.license)) {
                byte[] bytes = new byte[inputStream.available()];
                inputStream.read(bytes);
                sLicense = new String(bytes);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
        return sLicense;
    }
}
