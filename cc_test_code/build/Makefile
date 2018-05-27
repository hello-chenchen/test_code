project_dir = ../construct-destruct
inc_dir = $(project_dir)/inc
src_dir = $(project_dir)/src
objs_dir = ../objs/construct-destruct

objs = $(objs_dir)/class_define.o\
		$(objs_dir)/main.o

# $(objs): %.o: %.cc: %.h
# 	@echo "####################"
# 	@echo "start compile"
# 	g++ -I $< -c $< -o $@
# 	@echo "end compile"
# 	@echo "####################"
../objs/construct-destruct/class_define.o: $(inc_dir)/class_define.h \
	$(src_dir)/class_define.cc
	$(CXX) $(CFLAGS) -c $< -o $@

# main: $(objs)
# 	g++ -o main $(objs)

clean:
	rm $(objs) main
