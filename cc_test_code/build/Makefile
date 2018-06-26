CC = g++
PRO_DIR = ../algorithm_lib
INC_DIR = $(PRO_DIR)/inc
SRC_DIR = $(PRO_DIR)/src
CFLAGS = -g -I $(PRO_DIR)/inc
TARGET = main
OBJS = vector_util.o container_util.o main.o
# OBJS1 =  class_e.o

${TARGET}:${OBJS}# ${OBJS1}
	$(CC) -o $(TARGET) $(OBJS) $(OBJS1) $(CFLAGS)
$(OBJS):%.o:$(PRO_DIR)/src/%.cc
	$(CC) -c $(CFLAGS) $< -o $@
# $(OBJS1):%.o:../construct-destruct/src1/%.cc
# 	$(CC) -c $(CFLAGS) $< -o $@

clean:
	rm -rf $(TARGET) *.o