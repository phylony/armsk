

 # Copyright 2010, 2011 Project ARmsk
 # 
 # This file is part of ARmsk.
 # ARmsk is free software: you can redistribute it and/or modify
 # it under the terms of the GNU General Public License as published by
 # the Free Software Foundation, either version 3 of the License, or
 # (at your option) any later version.
 # ARmsk is distributed in the hope that it will be useful, 
 # but WITHOUT ANY WARRANTY; without even the implied warranty of
 # MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 # GNU General Public License for more details.
 # You should have received a copy of the GNU General Public License
 # along with ARmsk.  If not, see <http://www.gnu.org/licenses/>.
 



# The path to the NDK, requires crystax version r-4 for now, due to support
#for the standard library
ifndef ANDROID_NDK_BASE
$(warning attempting to use default dir for crystax...)
ANDROID_NDK_BASE = $(HOME)/android-ndk-r4-crystax
$(warning using: $(ANDROID_NDK_BASE) )
endif


#define OPENCV_ROOT when calling this makefile
#OPENCV_ROOT = $(ANDROID_NDK_BASE)/apps/opencv
ifndef OPENCV_ROOT
$(error Please define OPENCV_ROOT with something like the command \
make OPENCV_ROOT=<opencv>)
endif

ifndef PROJECT_PATH
$(info PROJECT_PATH defaulting to this directory)
PROJECT_PATH=.
endif


$(info OPENCV_ROOT = $(OPENCV_ROOT))

# The name of the native library
LIBNAME = libarmskdemoapp.so

# Find all the C++ sources in the native folder
SOURCES = $(wildcard jni/*.cpp)
HEADERS = $(wildcard jni/*.h)

ANDROID_MKS = $(wildcard jni/*.mk)

SWIG_IS = $(wildcard jni/*.i)

SWIG_MAIN = jni/armskdemoapp.i

SWIG_JAVA_DIR = src/com/ct/armsk/jni
SWIG_JAVA_OUT = $(wildcard $(SWIG_JAVA_DIR)/*.java)


SWIG_C_DIR = jni/gen
SWIG_C_OUT = $(SWIG_C_DIR)/armskdemoapp_swig.cpp

# The real native library stripped of symbols
LIB		= libs/armeabi-v7a/$(LIBNAME) libs/armeabi/$(LIBNAME)


all:	$(LIB)


#calls the ndk-build script, passing it OPENCV_ROOT and OPENCV_LIBS_DIR
$(LIB): $(SWIG_C_OUT) $(SOURCES) $(HEADERS) $(ANDROID_MKS)
	$(ANDROID_NDK_BASE)/ndk-build OPENCV_ROOT=$(OPENCV_ROOT) \
	OPENCV_LIBS_DIR=$(OPENCV_LIBS_DIR) PROJECT_PATH=$(PROJECT_PATH) V=$(V) $(NDK_FLAGS)

#this creates the swig wrappers
$(SWIG_C_OUT): $(SWIG_IS)
	make clean-swig &&\
	mkdir -p $(SWIG_C_DIR) &&\
	mkdir -p $(SWIG_JAVA_DIR) &&\
	swig -java -c++ -I$(OPENCV_ROOT)../shared/jni -package  "com.ct.armsk.jni" \
	-outdir $(SWIG_JAVA_DIR) \
	-o $(SWIG_C_OUT) $(SWIG_MAIN)
	
	
#clean targets
.PHONY: clean  clean-swig cleanall

#this deletes the generated swig java and the generated c wrapper
clean-swig:
	rm -f $(SWIG_JAVA_OUT) $(SWIG_C_OUT)
	
#does clean-swig and then uses the ndk-build clean
clean: clean-swig
	$(ANDROID_NDK_BASE)/ndk-build clean V=$(V) $(NDK_FLAGS)
